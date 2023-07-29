package storage

import entities.Accommodation

class AccommodationDataComperator {
    companion object {
        fun getNewAccommodations(oldDataset: List<Accommodation>, newDataset: List<Accommodation>): List<Accommodation> {
            return oldDataset.filterNot { oldItem -> newDataset.any { newItem -> oldItem.id == newItem.id } }
        }
    }
}