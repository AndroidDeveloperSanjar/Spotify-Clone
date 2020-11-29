package uz.androbeck.spotifyclone.data.db

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import uz.androbeck.spotifyclone.data.entities.Music
import uz.androbeck.spotifyclone.utils.Constants.MUSIC_COLLECTION

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val musicCollection = firestore.collection(MUSIC_COLLECTION)

    suspend fun getAllMusics(): List<Music> {
        return try {
            musicCollection.get().await().toObjects(Music::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}