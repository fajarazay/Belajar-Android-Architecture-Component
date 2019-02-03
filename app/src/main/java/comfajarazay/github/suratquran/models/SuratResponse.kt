package comfajarazay.github.suratquran.models

import com.google.gson.annotations.SerializedName

data class SuratResponse(
    @SerializedName("hasil")
    val hasil: MutableList<Hasil>,
    @SerializedName("query")
    val query: Query?,
    @SerializedName("status")
    val status: String?
)
