select car_id
from car_rental_company_car
where car_id in (
    select distinct car_id
    from car_rental_company_rental_history
    where month(start_date) = 10
) and car_type = '세단'
order by car_id desc;