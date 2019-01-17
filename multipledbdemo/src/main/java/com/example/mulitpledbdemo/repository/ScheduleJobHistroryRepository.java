package com.example.mulitpledbdemo.repository;

import com.example.mulitpledbdemo.model.ScheduleJobHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Transactional("h2Tx")
@Repository
public class ScheduleJobHistroryRepository {

    @Qualifier("h2")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;//=new JdbcTemplate(dataSource);

    private String createSQL = "create table if not exists Schedule_Job_History(   id integer not null AUTO_INCREMENT,   name varchar(255) not null,   start_time varchar(50) not null,   end_time varchar(50),   job_status varchar(50),   execution_status varchar(50),   execution_log varchar(2000),   primary key(id))AUTO_INCREMENT = 1;";

    public void createTable() {
        new JdbcTemplate(dataSource).execute(createSQL);
        System.out.println("table created.");

    }

    class ScheduleJobHistoryRowmapper implements RowMapper<ScheduleJobHistory> {

        @Override
        public ScheduleJobHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
//
//            String startDate = sdf.format(rs.getDate("start_time"));
//            String endDate = sdf.format(rs.getDate("end_time"));

            ScheduleJobHistory jobHistory = new ScheduleJobHistory(rs.getString("name"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getString("job_status"),
                    rs.getString("execution_status"),
                    rs.getString("execution_log"));

            jobHistory.setId(rs.getLong("id"));
            return jobHistory;
        }



    }
}
