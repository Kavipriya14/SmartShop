import { purchase } from './purchase';
import { Product } from '../product/product';
import { Quantity } from './quantity';

export interface purchaseHistory {
    id: number;
    quantity: Quantity;
    productCode: Product;
    purchase: purchase;
}