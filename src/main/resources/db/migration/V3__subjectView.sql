CREATE VIEW subject_view AS
SELECT s.*, t.fullname teacher
FROM subject s
       INNER JOIN teacher t ON s.teacher_id = t.id;
