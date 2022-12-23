create trigger insertLog
    after insert
    on userLogin
    for each row
    insert into log
    set log.user_id   = NEW.user_id,
        log.type      = "INSERT",
        log.table     = 'userLogin',
        log.parameter = concat("{user_name : ", NEW.user_name, " , password : ", NEW.password + "}"),
        log.startDate = now();