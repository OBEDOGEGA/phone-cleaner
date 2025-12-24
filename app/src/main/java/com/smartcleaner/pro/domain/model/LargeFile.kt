package com.smartcleaner.pro.domain.model

import java.io.File

data class LargeFile(
    val file: File,
    val size: Long,
    val lastModified: Long,
    val fileType: String,
    var isSelected: Boolean = true
)