package com.example.parsexml

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.StringReader

class XmlParser {
    companion object {
        private const val PARENT_TAG = "customer_data"
        private const val FIRST_CHILD_TAG = "id"
        private const val SECOND_CHILD_TAG = "first_name"
        private const val THIRD_CHILD_TAG = "last_name"
        private const val FOURTH_CHILD_TAG = "phone_number"
    }

    @Throws(IOException::class, XmlPullParserException::class)
    fun parse(): XmlData {
        val factory = XmlPullParserFactory.newInstance()
        val parser = factory.newPullParser()
        parser.setInput(StringReader(xmlSource()))
        parser.nextTag()
        return readData(parser)
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readData(parser: XmlPullParser): XmlData {
        parser.require(XmlPullParser.START_TAG, null, PARENT_TAG)
        var id = 0
        var firstName = ""
        var lastName = ""
        var phoneNumber = ""

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.eventType != XmlPullParser.START_TAG) {
                continue
            }
            when (parser.name) {
                FIRST_CHILD_TAG -> id = readInt(parser)
                SECOND_CHILD_TAG -> firstName = readString(parser)
                THIRD_CHILD_TAG -> lastName = readString(parser)
                FOURTH_CHILD_TAG -> phoneNumber = readString(parser)
                else -> skip(parser)
            }
        }
        return XmlData(
            id = id,
            firstName = firstName,
            lastName = lastName,
            phoneNumber = phoneNumber
        )
    }

    @Throws(IOException::class, XmlPullParserException::class)
    private fun readInt(parser: XmlPullParser): Int {
        var result = 0
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text.toInt()
            parser.nextTag()
        }
        return result
    }


    @Throws(IOException::class, XmlPullParserException::class)
    private fun readString(parser: XmlPullParser): String {
        var result = ""
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.text
            parser.nextTag()
        }
        return result
    }

    @Throws(IOException::class, XmlPullParserException::class)
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

    private fun xmlSource(): String {
        return ("<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
                + "<customer_data>"
                + "<id>2042</id>"
                + "<first_name>John</first_name>"
                + "<last_name>Adams</last_name>"
                + "<phone_number>010-1111-9999</phone_number>"
                + "</customer_data>"
                )
    }
}


