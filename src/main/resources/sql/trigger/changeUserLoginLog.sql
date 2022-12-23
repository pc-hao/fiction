create trigger updateLog
    after update
    on userLogin
    for each row
    insert into log
    set log.user_id   = NEW.user_id,
        log.type      = "UPADTE",
        log.table     = 'userLogin',
        log.parameter = concat("{user_name : ", NEW.user_name, " , oldPassword : ", OLD.password, " , newPassword : ", NEW.password + "}"),
        log.startDate = now();