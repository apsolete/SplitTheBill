package com.apsolete.splitthebill.relation;

import androidx.lifecycle.LiveData;
import androidx.room.Junction;
import androidx.room.Relation;

import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Party;
import com.apsolete.splitthebill.entity.Participant;

public class PartyWithParticipants extends Party {
    @Relation(parentColumn = "partyId", entityColumn = "mateId", associateBy = @Junction(Participant.class))
    public LiveData<Mate> participants;
}
