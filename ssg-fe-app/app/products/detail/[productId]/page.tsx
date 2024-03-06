import get from 'http';

async function getProductData({productId}: {productId: string}){
    const res = await fetch(`http://localhost:8000/api/products/${productId}`);
    if (!res.ok){
        throw new Error('Network Error');
    }
    const data = await res.json();
    return data;
}

export default async function Page({
    params
}:
    {
        params: {
            productId: string
        }
    }
) {

    const productData = await getProductData({productId: params.productId});

    return (
        <div>
            <h1>Product Detail product id {params.productId}</h1>
            <p>This is the Product detail page</p>
        </div>
    );
}