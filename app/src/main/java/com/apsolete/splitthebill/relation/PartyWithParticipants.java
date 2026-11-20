package com.apsolete.splitthebill.relation;

import androidx.room.Junction;
import androidx.room.Relation;

import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Party;
import com.apsolete.splitthebill.entity.Participant;

import java.util.List;

public class PartyWithParticipants extends Party {
    @Relation(parentColumn = "id", entityColumn = "id",
            associateBy = @Junction(value = Participant.class, parentColumn = "partyId", entityColumn = "mateId"))
    public List<Mate> participants;
}
