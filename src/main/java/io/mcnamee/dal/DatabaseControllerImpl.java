package io.mcnamee.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * class ___ is a member of the mcnameeio project.
 * <p>
 * Created by Luke on 4/25/2017.
 */
public class DatabaseControllerImpl implements DatabaseController {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseControllerImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveDataToScript() {

        final String sql = "SCRIPT TO 'data'";

        jdbcTemplate.execute(sql);
    }
}
