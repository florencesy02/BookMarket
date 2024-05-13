package BookMarket.controller;

import BookMarket.model.BookStorage;
import BookMarket.model.Cart;
import BookMarket.view.ConsoleView;

public class BookMarketController {
   
   ConsoleView view;
   BookStorage mBookStorage;
   Cart mCart;
   String[] menuList = {
      "0. 종료",
      "1. 도서 정보 보기",
      "2. 장바구니에 도서 담기",
      "3. 장바구니 보기",
      "4. 장바구니 비우기"   
   };

   public BookMarketController(BookStorage bookStorage, Cart cart, ConsoleView view) {
      this.view = view;
      this.mBookStorage = bookStorage;
      this.mCart = cart;
   }

   public void start() {
      view.displayWelcome();
      
      //menuNum을 받고 메뉴를 확인하니까 dowhile
      int menu;
      do {
         menu = view.selectMenu(menuList);
         
         switch(menu) {
         case 1:
            viewBookInfo();
            break;
         }
      }while(menu != 0);
      
   }
   private void addBook2Cart() {
	   view.displayBookInfo(mBookStorage);
	   int bookId = view.selectBookId(mBookStorage);
	   mCart.addItem(mBookStorage.getBookId(bookId));
	   view.showMessage("장바구니에 도서를 추가하였습니다.");
	   
   }
   
   private void viewCart() {
	   view.displayCart(mCart);
   }

   private void viewBookInfo() {
      view.displayBookInfo(mBookStorage);
      
      
   }

}