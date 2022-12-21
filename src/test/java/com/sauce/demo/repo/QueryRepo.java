package com.sauce.demo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//good example to present, should be modified

@Repository
public class QueryRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<String> getAccounts() {
        List<String> accountName = new ArrayList<>();
        accountName.addAll(jdbcTemplate.queryForList("select top 10 AccountName From Accounts", String.class));
        return accountName;
    }

    public List<String> getRiskIdByTitle(){
        List<String> riskTitle = new ArrayList<>();
        riskTitle.addAll(jdbcTemplate.queryForList("SELECT RiskId FROM Risks WHERE Title='RiskForTest'", String.class));
        return riskTitle;
    }
}
