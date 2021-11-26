package com.cryptenet.rwl_rest.domain.mapper

import com.cryptenet.rwl_rest.domain.model.DPO

abstract class ParcelableTransportableEntityMapper
<PARCELABLE : DPO, DTO : com.cryptenet.rwl_rest.domain.model.DTO> {
    abstract fun mapToParcelable(dto: DTO): PARCELABLE

    abstract fun mapFromParcelable(parcelable: DPO): DTO

    fun mapToParcelableList(dtoList: List<DTO>) =
        dtoList.map { mapToParcelable(it) }

    fun mapFromParcelableList(parcelableList: List<DPO>) =
        parcelableList.map { mapFromParcelable(it) }
}
