package com.example.uts_miniproject.Model

import android.content.Context

class DataUkurRepository(private val context: Context) {

    private val fileName = "data_ukur.txt"

    // Fungsi untuk membaca data dari file dan ubah ke list DataUkur
    fun getDataUkurList(): List<Student> {
        val dataList = mutableListOf<Student>()

        try {
            // Buka file
            val inputStream = context.openFileInput(fileName)
            var currentLine = ""
            val allLines = mutableListOf<String>()

            // Baca karakter satu per satu (tanpa BufferedReader / readLines)
            var charInt = inputStream.read()
            while (charInt != -1) {
                val character = charInt.toChar()
                if (character == '\n') {
                    allLines.add(currentLine)
                    currentLine = ""
                } else {
                    currentLine += character
                }
                charInt = inputStream.read()
            }

            // Tambahkan sisa baris terakhir jika tidak kosong
            if (currentLine != "") {
                allLines.add(currentLine)
            }

            inputStream.close()
        } catch (e: Exception) {
            // kalau file belum ada, biarkan kosong
        }

        return dataList
    }
}
