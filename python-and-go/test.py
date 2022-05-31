import logging
import click


@click.command()
@click.option("--param_1", help="Param_1")
@click.option("--param_2", help="Param_2")
@click.option("--message", help="Message for everyone")
def main(param_1, param_2, message):
    logging.info(f"Starting")
    param_3 = param_1 + param_2

    print(param_3)
    print(message)
    return param_3


if __name__ == "__main__":
    main()
