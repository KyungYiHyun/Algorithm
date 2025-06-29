WITH TEMP AS (SELECT D.ID,D.EMAIL,
CASE WHEN (D.SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'Python')) > 0
AND (D.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')) > 0            
THEN 'A'
WHEN (D.SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME = 'C#')) > 0
THEN 'B'
WHEN (D.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End')) > 0  
THEN 'C'
END AS GRADE
FROM DEVELOPERS D)

SELECT T.GRADE, T.ID, T.EMAIL
FROM TEMP T
WHERE T.GRADE IS NOT NULL
ORDER BY T.GRADE,T.ID

