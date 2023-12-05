select h.hour , nvl(c.count, 0)
FROM
    (select LEVEL-1 as hour
        from
            dual
        connect BY LEVEL <= 24) h
left Join (select TO_CHAR(DATETIME, 'HH24') as hour, count(animal_id) as count
from animal_outs
GROUP BY
    TO_CHAR(DATETIME, 'HH24')) c
on h.hour = c.hour
order by h.hour