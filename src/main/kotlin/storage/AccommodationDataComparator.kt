package storage

import entities.Accommodation

class AccommodationDataComparator {
    companion object {
        fun getNewAccommodations(oldDataset: List<Accommodation>, newDataset: List<Accommodation>): List<Accommodation> {
            return newDataset.filterNot { newItem -> oldDataset.any { oldItem -> newItem.id == oldItem.id } }
        }
    }
}