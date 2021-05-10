import time
import pyupbit
import datetime
access = ""
secret = ""

def get_target_price(ticker, k):
    df = pyupbit.get_ohlcv(ticker, interval="day", count=2)
    target_price = df.iloc[0]['close'] + (df.iloc[0]['high'] - df.iloc[0]['low']) * k
    return target_price

def get_start_time(ticker):
    df = pyupbit.get_ohlcv(ticker, interval="day", count=1)
    start_time = df.index[0]
    return start_time

def get_ma15(ticker):
    df = pyupbit.get_ohlcv(ticker, interval="day", count=15)
    ma15 = df['close'].rolling(15).mean().iloc[-1]
    return ma15

def get_balance(ticker):
    balances = upbit.get_balances()
    for b in balances:
        if b['currency'] == ticker:
            if b['balance'] is not None:
                return float(b['balance'])
            else:
                return 0

def get_current_price(ticker):
    return pyupbit.get_orderbook(tickers=ticker)[0]["orderbook_units"][0]["ask_price"]

upbit = pyupbit.Upbit(access, secret)
print("autotrade start")

while True:
    try:
        list_krw = ["KRW-ETH","KRW-BTC","KRW-ETC","KRW-BCH","KRW-XRP"]
        list_name = ["ETH","BTC","ETC","BCH","XRP"]
        for i in range(0,5):
            now = datetime.datetime.now()
            start_time = get_start_time(list_krw[i])
            end_time = start_time + datetime.timedelta(days=1)
            if type(upbit.get_avg_buy_price(list_name[i])) is None :
                avg_price = 0
            else :
                avg_price = upbit.get_avg_buy_price(list_name[i])
            
            target_price = get_target_price(list_krw[i], 0.32)
            ma15 = get_ma15(list_krw[i])
            current_price = get_current_price(list_krw[i])

            if start_time < now < end_time - datetime.timedelta(seconds=120):
                if target_price < current_price and ma15 < current_price:
                    krw = get_balance("KRW")
                    if krw > 5000:
                        upbit.buy_market_order(list_krw[i], krw*0.9995)
                if avg_price * 0.965 > current_price and avg_price != 0:
                    btc = get_balance(list_name[i])
                    if btc*current_price*0.9995 > 5000:
                        upbit.sell_market_order(list_krw[i],btc*0.9995)
                        sleep(180)
            else:
                btc = get_balance(list_name[i])
                if btc*current_price*0.9995 > 5000:
                    upbit.sell_market_order(list_krw[i], btc*0.9995)
            if get_balance(list_name[i]) is None :
                balance = 0
            else :
                balance = get_balance(list_name[i])
            
            print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
            print("KRW : \t\t"+(str)(get_balance("KRW")))
            print("\t"+list_name[i])
            print("avg_buy_price : "+(str)(avg_price))
            print("balance : \t" + (str)(balance*current_price))
            print("target_price : \t" + (str)(target_price))
            print("avg * 0.965 : \t"+(str)(avg_price*0.965))
            print("ma15 : \t\t" + (str)(ma15))
            print("current_price : " + (str)(current_price))
            print("-----------------")
            time.sleep(1)

    except Exception as e:
        print(e)
        time.sleep(1)
