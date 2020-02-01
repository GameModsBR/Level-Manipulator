package br.com.gamemods.levelmanipulator.catalog.api

import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import java.util.*

@Throws(IOException::class)
inline fun <R> Any.resourceStream(resource: String, action: (InputStream) -> R): R {
    val stream = this::class.java.getResourceAsStream(resource) ?: throw FileNotFoundException("Resource: $resource")
    return stream.use(action)
}

inline fun <R> Any.resourceReader(resource: String, charset: Charset = Charsets.UTF_8, action: (BufferedReader) -> R): R {
    return resourceStream(resource) {
        action(it.bufferedReader(charset))
    }
}

fun Any.resourceProperties(resource: String, charset: Charset = Charsets.UTF_8): Properties {
    return resourceReader(resource, charset) {
        Properties().apply {
            load(it)
        }
    }
}
