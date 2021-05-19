import time
import pyupbit
import datetime
access = ""
secret = ""


def get_balance(ticker):
    balances = upbit.get_balances()
    for b in balances:
        if b['currency'] == ticker:
            if b['balance'] is not None:
                return float(b['balance'])
            else:
                return 0

def get_20(ticker):
    df = pyupbit.get_ohlcv(ticker,interval="minute1",count=21)
    return df

def get_current_price(ticker):
    return pyupbit.get_orderbook(tickers=ticker)[0]["orderbook_units"][0]["ask_price"]

upbit = pyupbit.Upbit(access, secret)

while True:
    try:
            print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
            print("KRW : \t\t"+(str)(get_balance("KRW")))
            #ma10 = get_ma10("KRW-ETH")
            get20 = get_20("KRW-ETH")
            print((str)(get20['open'][0]-get20['close'][0]))
            state20 = 1 if get20['open'][0] - get20['close'][0] > 0 else [-1 if get20['open'][0] - get20['close'][0] == 0 else 0]
            print((str)(get20))
            print((str)(state20))
            print("-----------------")
            time.sleep(1)

    except Exception as e:
        print(e)
        time.sleep(1)
