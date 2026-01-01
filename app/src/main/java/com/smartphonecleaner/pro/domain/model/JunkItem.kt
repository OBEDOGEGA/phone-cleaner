package com.smartphonecleaner.pro.domain.model

import java.io.File

data class JunkItem(
    val file: File,
    val size: Long,
    val type: JunkType,
    val category: String,
    var isSelected: Boolean = true
)

enum class JunkType {
    CACHE,
    RESIDUAL,
    APK,
    EMPTY_FOLDER,
    THUMBNAIL
}