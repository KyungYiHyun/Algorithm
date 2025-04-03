WITH TEMP AS (SELECT H.EMP_NO, SUM(H.SCORE) AS TOTAL
FROM HR_GRADE H
WHERE H.YEAR = '2022'
GROUP BY H.EMP_NO
ORDER BY TOTAL DESC
LIMIT 1)


SELECT TOTAL AS SCORE, E.EMP_NO, E.EMP_NAME, E.POSITION, E.EMAIL
FROM HR_EMPLOYEES E JOIN TEMP T
ON E.EMP_NO = T.EMP_NO
