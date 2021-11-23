package com.electrics.watching.data.prefs

import androidx.datastore.preferences.protobuf.Timestamp

data class SchedulePreferences(
    val lastUpdate: Timestamp
)