package com.example.httpgetpractice.menu

import com.example.httpgetpractice.model.Menu
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.StringReader

class MenuPageXmlParser {

    companion object {
        private const val PARENT_TAG = "menu"
    }

    @Throws(XmlPullParserException::class, IOException::class)
    fun parseXml(xmlString: String): MutableList<Menu> {
        val factory = XmlPullParserFactory.newInstance()
        val parser = factory.newPullParser()
        parser.setInput(StringReader(xmlString))
        parser.nextTag()
        return readAppMenu(parser)
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readAppMenu(parser: XmlPullParser): MutableList<Menu> {
        val menuList = mutableListOf<Menu>()

        parser.require(XmlPullParser.START_TAG, null, PARENT_TAG)
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            if (parser.name == "contents") {
                menuList.add(readMenu(parser))
            } else {
                skip(parser)
            }
        }
        return menuList
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun readMenu(parser: XmlPullParser): Menu {
        parser.require(XmlPullParser.START_TAG, null, "contents")
        var url: String = ""
        var text: String = ""
        var index: Int = 0
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            when (parser.name) {
                "url" -> url = readUrl(parser)
                "text" -> text = readText(parser)
                "index" -> index = readIndex(parser)
                else -> skip(parser)
            }
        }
        return Menu(index, text, url)
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readUrl(parser: XmlPullParser): String {
        parser.require(XmlPullParser.START_TAG, null, "url")
        val url = readText(parser)
        parser.require(XmlPullParser.END_TAG, null, "url")
        return url
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readText(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readIndex(parser: XmlPullParser): Int {
        var result = 0
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text.toInt()
            parser.nextTag()
        }
        return result
    }

    @Throws(XmlPullParserException::class, IOException::class)
    private fun skip(parser: XmlPullParser) {
        if (parser.eventType != XmlPullParser.START_TAG) {
            throw IllegalStateException()
        }
        var depth = 1
        while (depth != 0) {
            when (parser.next()) {
                XmlPullParser.END_TAG -> depth--
                XmlPullParser.START_TAG -> depth++
            }
        }
    }

}