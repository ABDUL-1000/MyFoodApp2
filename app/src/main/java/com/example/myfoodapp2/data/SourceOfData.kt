package com.example.myfoodapp2.data

import com.example.myfoodapp2.model.Declaration
import com.example.myfoodapp2.R

class SourceOfData {
    fun displayDeclaration(): List<Declaration>{
        return listOf(
            Declaration( R.drawable.akpu, "AKPU", "#50", R.string.Akpu_detail),
            Declaration( R.drawable.amala, "AMALA","#750",R.string.Amala_detail),
            Declaration(R.drawable.eba,"EBA", "#500", R.string.Eba_detail),
            Declaration(R.drawable.fr,"FRIED RICE","#700", R.string.Fried_Rice_detail),
            Declaration(R.drawable.jolof,"JOLLOF RICE","#900", R.string.Jolof_Rice_detail),
            Declaration(R.drawable.moi,"MOI MOI", "#750",R.string.Moi_Moi_detail),
            Declaration(R.drawable.noodlels,"NOODLES","#1000", R.string.Noodles_detail),
            Declaration(R.drawable.tuwo,"TUWO", "#150", R.string.Tuwo_detail)
        )
    }
}
