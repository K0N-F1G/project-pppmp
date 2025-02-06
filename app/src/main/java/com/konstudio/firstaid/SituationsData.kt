package com.konstudio.firstaid

import android.os.Parcel
import android.os.Parcelable

data class SituationsData(val name : String, val img : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SituationsData> {
        override fun createFromParcel(parcel: Parcel): SituationsData {
            return SituationsData(parcel)
        }

        override fun newArray(size: Int): Array<SituationsData?> {
            return arrayOfNulls(size)
        }
    }

}
