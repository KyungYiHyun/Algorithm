SELECT T.EMP_NO,HE.EMP_NAME,
CASE 
WHEN AVG_SCORE >= 96 THEN 'S'
WHEN AVG_SCORE >= 90 THEN 'A'
WHEN AVG_SCORE >= 80 THEN 'B'
ELSE 'C'
END AS GRADE,
CASE 
WHEN AVG_SCORE >= 96 THEN SAL * 0.20
WHEN AVG_SCORE >= 90 THEN SAL * 0.15
WHEN AVG_SCORE >= 80 THEN SAL * 0.10
ELSE 0
END AS BONUS
FROM HR_EMPLOYEES HE
JOIN 
(SELECT H.EMP_NO, G.YEAR, AVG(G.SCORE) AS AVG_SCORE
FROM HR_EMPLOYEES H
JOIN HR_GRADE G
ON H.EMP_NO = G.EMP_NO
GROUP BY G.YEAR, H.EMP_NO) T
ON HE.EMP_NO = T.EMP_NO
ORDER BY HE.EMP_NO
