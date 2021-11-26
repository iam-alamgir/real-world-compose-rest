package com.cryptenet.rwl_rest.domain.mapper

import com.cryptenet.rwl_rest.domain.model.DPO
import com.cryptenet.rwl_rest.domain.model.DSO

abstract class ParcelableStorableEntityMapper
<PARCELABLE : DPO, STORABLE : DSO> {
    abstract fun mapToParcelable(storable: STORABLE): PARCELABLE

    abstract fun mapFromParcelable(parcelable: DPO): STORABLE

    fun mapToParcelableList(storableList: List<STORABLE>) =
        storableList.map { mapToParcelable(it) }

    fun mapFromParcelableList(parcelableList: List<DPO>) =
        parcelableList.map { mapFromParcelable(it) }
}
