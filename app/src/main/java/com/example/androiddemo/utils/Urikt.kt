package com.example.androiddemo.utils

import android.net.Uri
import java.io.File

/**
 * @author Menglingshuai
 * @date 2019-11-29.
 * email：mlsnatalie@163.com
 * description：
 */

/**
 * Creates a Uri from the given encoded URI string.
 *
 * @see Uri.parse
 */
inline fun String.toUri(): Uri = Uri.parse(this)

/**
 * Creates a Uri from the given file.
 *
 * @see Uri.fromFile
 */
inline fun File.toUri(): Uri = Uri.fromFile(this)

/** Creates a [File] from the given [Uri]. */
fun Uri.toFile(): File {
    require(scheme == "file") { "Uri lacks 'file' scheme: $this" }
    return File(path)
}