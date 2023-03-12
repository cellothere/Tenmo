package com.techelevator.dao;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.JdbcUserDao;
import com.techelevator.tenmo.model.Transfer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class JdbcTransferDaoTests extends BaseDaoTests {

    //TODO add transferID
    protected static final Transfer Transfer_1 = new Transfer(3001,1, 2, 2001, 2002, BigDecimal.valueOf(111.11));
    protected static final Transfer Transfer_2 = new Transfer(1, 2, 2002, 2001, BigDecimal.valueOf(222.22));
    protected static final Transfer Transfer_3 = new Transfer(2, 1, 2001, 2001, BigDecimal.valueOf(500));

    private JdbcTransferDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcTransferDao(jdbcTemplate);
    }

    @Test
    public void getTransferById_given_valid_id_returns_transfer() {
        String actualTransfer = sut.getTransferById(3001);

        Assert.assertEquals(Transfer_1.toString(), actualTransfer);
    }

    @Test
    public void getAllTransfers_returns_all_transfers(){
        List<Transfer> allTestTransfers = new ArrayList<>();
        allTestTransfers.add(Transfer_1);
        allTestTransfers.add(Transfer_2);

        Assert.assertEquals(allTestTransfers.size(), sut.seeMyTransfers(2001).size());
    }

    //TODO how to test when this involves retrieving account balance?
//    @Test
//    public boolean transferAllowed_allows_valid_transfer(){
//
//    }
//
//
//    @Test
//    public boolean transferAllowed_does_not_allow_invalid_transfer(){
//
//    }

}
