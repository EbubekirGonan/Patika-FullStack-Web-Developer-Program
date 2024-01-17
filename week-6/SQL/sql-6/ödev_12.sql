--film tablosunda film uzunluğu length sütununda gösterilmektedir. Uzunluğu ortalama film uzunluğundan fazla kaç tane film vardır?

SELECT COUNT(*) FROM film
WHERE LENGTH > ANY(
	SELECT AVG(length) FROM film);

--film tablosunda en yüksek rental_rate değerine sahip kaç tane film vardır?

SELECT COUNT(*) FROM film
WHERE rental_rate = ANY (
	SELECT MAX(rental_rate) FROM film)

--film tablosunda en düşük rental_rate ve en düşün replacement_cost değerlerine sahip filmleri sıralayınız.
(
	SELECT * FROM film
WHERE rental_rate = ANY(
	SELECT MIN(rental_rate) FROM film
)
)
INTERSECT
(
	SELECT * FROM film
WHERE replacement_cost = ANY(
	SELECT MIN(replacement_cost) FROM film
)
)

--payment tablosunda en fazla sayıda alışveriş yapan müşterileri(customer) sıralayınız.

SELECT CONCAT(customer.first_name, ' ', customer.last_name) AS customer, payment.customer_id AS "customer id", COUNT(*) AS "number of purchases" FROM payment
INNER JOIN customer ON customer.customer_id = payment.customer_id
GROUP BY payment.customer_id, customer.first_name, customer.last_name
ORDER BY COUNT(*) DESC

