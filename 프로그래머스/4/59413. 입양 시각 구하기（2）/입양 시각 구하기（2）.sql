with recursive temp as(
    select 0 as h
    union all
    select h + 1
    from temp
    where h < 23
)

select t.h AS HOUR, coalesce(count(a.animal_id), 0) AS COUNT
from animal_outs a
right outer join temp t
on hour(datetime) = t.h 
group by t.h
order by HOUR;