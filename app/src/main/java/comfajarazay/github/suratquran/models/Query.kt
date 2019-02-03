package comfajarazay.github.suratquran.models

import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("format")
    val format: String?,
    @SerializedName("surat")
    val surat: String?
)