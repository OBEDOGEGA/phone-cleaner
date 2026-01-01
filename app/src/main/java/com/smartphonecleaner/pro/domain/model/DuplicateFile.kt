package com.smartphonecleaner.pro.domain.model

import java.io.File

data class DuplicateFile(
    val file: File,
    val size: Long,
    val md5Hash: String,
    val duplicateGroup: List<File>,
    var isSelected: Boolean = true
)