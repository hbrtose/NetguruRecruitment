package com.eniro.netgururecruitment.data

import android.os.Parcel
import android.os.Parcelable

data class ListItemData(
    val name: String,
    val color: Int,
    val timestamp: Long
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(color)
        parcel.writeLong(timestamp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ListItemData> {
        override fun createFromParcel(parcel: Parcel): ListItemData {
            return ListItemData(parcel)
        }

        override fun newArray(size: Int): Array<ListItemData?> {
            return arrayOfNulls(size)
        }
    }
}