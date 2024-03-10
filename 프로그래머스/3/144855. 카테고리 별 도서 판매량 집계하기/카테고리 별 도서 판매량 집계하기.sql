SELECT B.CATEGORY, SUM(BS.SALES)  AS TOTAL_SALES

FROM
    BOOK_SALES BS
LEFT JOIN
    BOOK B
ON BS.BOOK_ID = B.BOOK_ID
WHERE TO_CHAR(BS.SALES_DATE, 'YYYYMM') = '202201'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY ASC