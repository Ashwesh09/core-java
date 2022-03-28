use org;
DELIMITER // 
CREATE TRIGGER after_insert_into_worker
AFTER INSERT
ON worker FOR EACH ROW
BEGIN
    INSERT INTO title
        values(worker_ref_id,"New Joinee",NOW())
    ;
END // 
DELIMITER ;


DELIMITER //
CREATE TRIGGER after_update_into_worker
AFTER UPDATE
ON worker FOR EACH ROW
BEGIN
    UPDATE title 
    set worker_ref_id = NEW.worker_id WHERE worker_ref_id = OLD.worker_id;
END //
DELIMITER ;


DELIMITER //
CREATE TRIGGER after_worker_delete
AFTER DELETE
ON worker
FOR EACH ROW
BEGIN
       DELETE FROM title WHERE worker_ref_id=OLD.worker_id;
END //
DELIMITER ;