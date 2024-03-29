SELECT
    TO_CHAR(OS.SALES_DATE, 'YYYY') AS YEAR,
    TO_NUMBER(TO_CHAR(OS.SALES_DATE, 'MM')) AS MONTH,
    COUNT(DISTINCT OS.USER_ID),
    ROUND(COUNT(DISTINCT OS.USER_ID) / (SELECT COUNT(USER_ID) FROM USER_INFO WHERE TO_CHAR(JOINED, 'YYYY') = 2021), 1)
FROM
    ONLINE_SALE OS
JOIN
    USER_INFO UI
ON OS.USER_ID = UI.USER_ID
WHERE TO_CHAR(UI.JOINED, 'YYYY') = 2021
GROUP BY
    TO_CHAR(OS.SALES_DATE, 'YYYY'), TO_CHAR(OS.SALES_DATE, 'MM')
ORDER BY 1,2