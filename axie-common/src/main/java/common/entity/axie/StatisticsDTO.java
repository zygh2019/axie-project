/**
  * Copyright 2021 bejson.com 
  */
package common.entity.axie;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2021-11-30 18:24:59
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class StatisticsDTO {

    private String job_id;
    private String game_account_tag;
    private String game_account;
    private String player_tag;
    private String axie;
    private String mmr;
    private Date next_claim_time;
    private String slp_last;
    private Date slp_update_time;
    private String ratio_platform;
    private String last_slp_earnings;
    private String slp_earnings;
    private String slp_earnings_total;

}