import './App.css'
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Header from './components/Header';
import Title from './components/Title'
import MoneyBar from './components/MoneyBar';
import ProductContainer from './components/ProductContainer';


function App() {
  const [products, setProducts] = useState([])
  const [totalMoney, setTotalMoney] = useState(100000000000)


  useEffect(() => {
    axios
    .get("https://dummyjson.com/products")
    .then((response) => {
      setProducts(response.data.products);
      console.log(products);
    })
  }, [])


  return (
    <>
      {/* header */}
      <div className="page">

        <Header/>

        <div className="container">

          <div>

            <Title/>
            <div id='money-bar'>
              < MoneyBar totalMoney={totalMoney} />
            </div>
            <ProductContainer products={products} totalMoney={totalMoney} setTotalMoney={setTotalMoney} />
          </div>
          

        </div>
      </div>


     
    </>
  )
}

export default App
