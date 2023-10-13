SELECT p.name,
  SUM(
    CASE
      WHEN p.finish_date IS NULL THEN (DATEDIFF(MONTH, p.start_date, CURRENT_DATE) * w.salary)
      ELSE (DATEDIFF(MONTH, p.start_date, p.finish_date) * w.salary)
    END
  ) price 
FROM project p
JOIN project_worker pw ON pw.project_id=p.id 
JOIN worker w ON w.id=pw.worker_id
GROUP BY p.name
ORDER BY price DESC;
