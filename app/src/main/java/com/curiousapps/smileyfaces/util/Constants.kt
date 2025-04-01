package com.curiousapps.smileyfaces.util

import kotlinx.coroutines.Dispatchers

const val BASE_URL = "https://emoji-api.com/"
const val URL_EXT = "emojis?access_key=c41eff2060a60821aa1176201a24d7dd8febb31d"
const val URL_ONE = "emojis/{slug}?access_key=c41eff2060a60821aa1176201a24d7dd8febb31d"

var IO_DISPATCHER = Dispatchers.IO