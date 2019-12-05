import { User } from '../register/user';

export interface purchase {
    id: number;
    date: Date;
    totalAmount: number;
    user: User;
}
