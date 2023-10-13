SELECT NAME, month_count
FROM (SELECT *, 
	CASE 
		WHEN finish_date IS NULL THEN DATEDIFF(MONTH, start_date, CURRENT_DATE)
	    ELSE DATEDIFF(MONTH, start_date, finish_date)
	END month_count
	FROM project)
WHERE month_count = (
	SELECT MAX(month_count) 
	FROM (SELECT  
		CASE 
			WHEN finish_date IS NULL THEN DATEDIFF(MONTH, start_date, CURRENT_DATE)
	        ELSE DATEDIFF(MONTH, start_date, finish_date)
		END month_count
		FROM project));