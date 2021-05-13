import time
import pyupbit
import datetime
access = ""
secret = ""

def get_ma10(ticker):
    df = pyupbit.get_ohlcv(ticker, interval="minute1", count=11)
    print(df)
    ma10 = df['close'].rolling(11).mean().iloc[-1]
    return ma10

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
            print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
            print("KRW : \t\t"+(str)(get_balance("KRW")))
            ma10 = get_ma10("KRW-ETH")
            print((str)(ma10))
            print("-----------------")
            time.sleep(1)

    except Exception as e:
        print(e)
        time.sleep(1)
