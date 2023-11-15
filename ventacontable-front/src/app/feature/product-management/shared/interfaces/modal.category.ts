import { Category } from "./category";

export interface ModalCategory {
    category: Category | undefined,
    updated: boolean,
    delete: boolean,
    add: boolean
}