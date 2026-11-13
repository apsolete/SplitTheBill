package com.apsolete.splitthebill.relation;

import com.apsolete.splitthebill.entity.Bill;
import com.apsolete.splitthebill.entity.Mate;

import java.util.List;

public class SplittedBill extends Bill {
    public List<Mate> mates;
    public List<SplittedDish> dishes;
}
