package com.konstudio.firstaid

import com.konstudio.firstaid.Situations.Multipage.MP_UBP_Activity
import com.konstudio.firstaid.Situations.Onepage.OP_UBP_Activity
import com.konstudio.firstaid.Situations.Slidable.SLIDE_UBP_Activity

class ActivitiesMap {
    val activitiesOP = mapOf(
        "Устойчивое Боковое Положение" to OP_UBP_Activity::class.java
    )
    val activitiesMP = mapOf(
        "Устойчивое Боковое Положение" to MP_UBP_Activity::class.java
    )
    val activitiesSLIDE = mapOf(
        "Устойчивое Боковое Положение" to SLIDE_UBP_Activity::class.java
    )
}